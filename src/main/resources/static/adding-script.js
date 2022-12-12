(async function(){
    let elem = document.getElementById("button_add");
    elem.addEventListener("click", click_add);
    let elemBack = document.getElementById("back-to-list");
    elemBack.addEventListener("click", redirecting);

    function redirecting() {
        window.location.href = '/';
    }

    async function click_add() {
        const response = await fetch("api/products/add", {
            method: "POST",
            headers: { "Accept": "application/json", "Content-Type": "application/json" },
            body: JSON.stringify({
                productName: document.getElementById("productName").value,
            })
        });
        if (response.ok === true) {
            redirecting()
        }
    }
})();