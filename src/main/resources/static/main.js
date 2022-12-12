(async function(){

    let list = [];

    const response = await fetch("/api/products/", {
        method: "GET",
        headers: { "Accept": "application/json" }
    });

    if (response.ok === true) {

        list = await response.json();

        let product;
        for (product of list) {
            append_table_list(product);
        }
        let elem = document.getElementById("btn_to_add");
        elem.addEventListener("click", redirecting);
    }
    async function redirecting() {
        window.location.href = '/add';
    }
    async function click_delete(event) {
        const response = await fetch(`/api/products/delete/${event.target.id}`,{
            method: "DELETE",
            headers: { "Accept": "application/json" }
        });
        if (response.ok === true) {
            window.location.href = '/';
        }
    }

    async function click_update(event) {
        await fetch(`/api/products/update/${event.target.id}`,{
            method: "POST",
            headers: { "Accept": "application/json" }
        });
    }

    function append_table_list(product) {
        let products = document.getElementById("products");
        let child = document.createElement("div")
        child.innerHTML += `${product.name}`;
        child.innerHTML += `<input type="button" class="btn_del" id="${product.id}" value="х">`;
        child.innerHTML += `<input type="checkbox" class="btn_upd" id="${product.id}" ${product.bought ? 'checked' : ''} value="${product.bought}">`
        products.appendChild(child);
        child.querySelector(".btn_del").addEventListener("click", click_delete);
        child.querySelector(".btn_upd").addEventListener("change", click_update);
    }
})();