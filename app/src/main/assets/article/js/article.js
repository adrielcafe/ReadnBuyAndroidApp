// Open the product
$(".product").click(function(){
    var productUrl = "http://product/" + $(this).data("product-id")
    window.open(productUrl)
})