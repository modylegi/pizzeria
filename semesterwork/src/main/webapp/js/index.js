const btnSuccess = document.querySelector(".button-make-order")

btnSuccess.addEventListener('click',()=>{
    alert("Заказ софрмирован")
})



$(document).ready(function() {
    // Get product list via Ajax
    $.ajax({
        url: '/products',
        type: 'GET',
        success: function(products) {
            // Populate the product list
            var productList = $('#product-list');
            productList.empty();
            $.each(products, function(index, product) {
                productList.append('<div class="product">' +
                    '<h3>' + product.name + '</h3>' +
                    '<p>Price: $' + product.price + '</p>' +
                    '<button class="add-to-cart-btn" data-id="' + product.id + '">Add to Cart</button>' +
                    '</div>');
            });
        }
    });

    // Add item to cart
    $(document).on('click', '.add-to-cart-btn', function() {
        var productId = $(this).data('id');

        $.ajax({
            url: '/cart',
            type: 'POST',
            data: JSON.stringify({ productId: productId }),
            contentType: 'application/json',
            success: function() {
                alert('Item added to cart');
            }
        });
    });

    // Update item quantity in cart
    $(document).on('change', '.quantity-input', function() {
        var cartItemId = $(this).data('id');
        var quantity = $(this).val();

        $.ajax({
            url: '/cart/' + cartItemId,
            type: 'PUT',
            data: JSON.stringify({ quantity: quantity }),
            contentType: 'application/json',
            success: function() {
                alert('Cart item quantity updated');
            }
        });
    });

    // Remove item from cart
    $(document).on('click', '.remove-from-cart-btn', function() {
        var cartItemId = $(this).data('id');

        $.ajax({
            url: '/cart/' + cartItemId,
            type: 'DELETE',
            success: function() {
                alert('Item removed from cart');
            }
        });
    });

    // Get cart items via Ajax
    $.ajax({
        url: '/cart',
        type: 'GET',
        success: function (cartItems) {
            // Populate the cart items
            var cartTable = $('#cart-items');
            cartTable.empty();
            $.each(cartItems, function (index, cartItem) {
                cartTable.append('<tr>' +
                    '<td>' + cartItem.name + '</td>' +
                    '<td>$' + cartItem.price + '</td>' +
                    '<td><input class="quantity-input" type="number" min="1" value="' + cartItem.quantity + '" data-id="' + cartItem.id + '"></td>' +
                    '<td><button class="remove-from-cart-btn" data-id="' + cartItem.id + '">Remove</button></td>' +
                    '</tr>');
            });
        }
    });