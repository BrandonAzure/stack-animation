
class Conversion {

    constructor(infix) {
        this.infix = infix;
        this.prefix = "";
        this.number = "";
        this.index = 0;
    }

    prefixConversation() {
        let reverseInfix = "";
        
        for (let i = (this.infix.length - 1); i >= 0; i--) {
            reverseInfix+= this.infix[i];
        }

        this.infix = reverseInfix;

        console.log(this.infix);
    }
}