const btnSuccess = document.querySelector(".button-make-order")

btnSuccess.addEventListener('click',()=>{
    alert("Заказ софрмирован")
})

$(document).ready(function() {


    $('.add-to-cart-btn').click(function() {
        var product = {
            id: $("#product-id").val(),
            // quantity: $("#quantity").val()
        };

        $.ajax({
            type: "POST",
            url: "/api/v1/cart",
            contentType: "application/json",
            data: JSON.stringify(product),
            success: function() {
                alert("Item added to cart!");
            },
            error: function() {
                alert("Error adding item to cart!", this.data);
            }
        });
    });


    $(".remove-from-cart-btn").click(function() {
        var item = {
            id: $(this).data("cart-item-id")
        };

        $.ajax({
            type: "POST",
            url: "/cart/remove",
            contentType: "application/json",
            data: JSON.stringify(item),
            success: function() {
                alert("Item removed from cart!");
            },
            error: function() {
                alert("Error removing item from cart!");
            }
        });
    });

});



