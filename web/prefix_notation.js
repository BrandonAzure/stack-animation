let buttonGenerete = document.getElementById("generete");
let arithmeticExpression = "";
buttonGenerete.addEventListener("click",(ActionEvent) =>{
    arithmeticExpression = document.getElementById("input-expression").value;

    new Conversion(arithmeticExpression).prefixConversation();
});

var cards = document.getElementsByClassName('card');
for (var i = 0; i < cards.length; i++) {
    (function(index) {
        setTimeout(function() {
            cards[index].classList.add('animate-sweep');
        }, index * 200); // Ajusta el retardo entre cada elemento animado
    })(i);
}
