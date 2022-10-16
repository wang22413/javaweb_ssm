function cart(book , buyCount) {
    window.location.href="editCart/" + book + "/" + buyCount;
}

window.onload=function () {
    var vue = new Vue({
        el:"#cart_div",
        data:{},
        methods: {
            getCart:function() {
                axios({
                    method:"POST",
                    url:"cart.do",
                    params: {
                        operate:'cartInfo'
                    }
                })
                    .then(function (value) {
                        console.log(value.data)
                    })
                    .catch(function (reason) {

                    });
            }
        },
        beforemount:{
            getCartInfo:function () {
                vue.getCart();
            }
        }
    });
}