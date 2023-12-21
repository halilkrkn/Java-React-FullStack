//TODO: OPP and Map,Filter, Reduce in JavaScript

class Customer{
    constructor(id,customerNumber) {
        this.id = id;
        this.customerNumber = customerNumber;
    }
}

let customer = new Customer(1, "12345");
//*prototyping
customer.name = "Halil İbrahim Karkın"
console.log(customer.name);

Customer.bisey = "Bişey"
console.log(Customer.bisey);

console.log(customer.customerNumber);

class IndividualCustomer extends Customer{
    constructor(firstName,id,customerNumber){
        super(id,customerNumber)
        this.firstName = firstName
    }
}

class CorporateCustomer extends Customer{
    constructor(companyName,id,customerNumber){
        super(id,customerNumber)
        this.companyName = companyName
    }
}

let products = [
    {id:1, name : "Siemens", unitPrice:300},
    {id:2, name : "Bosch", unitPrice:500},
    {id:3, name : "Arcelik", unitPrice:800},
    {id:4, name : "Delonghi", unitPrice:900},
    {id:5, name : "White Westinghouse", unitPrice:1000},
]


// Map, Filter, Reduce
console. log("<ul>")
products.map((product)=>console.log(`<li>${product.name}</li>`))
console. log("</ul>")


let filteredProducts = products.filter(product=>product.unitPrice>500)
console.log(filteredProducts);

let cartTotal = products.reduce((acc, product)=> acc + product.unitPrice, 0)
console.log(cartTotal);

let cartTotal2 = products
    .filter(p=>p.unitPrice>300)
    .map(p=>{
        p.unitPrice = p.unitPrice * 1.18;
        return p;
    })
    .reduce((acc, p)=> acc + p.unitPrice, 0)

console.log(cartTotal2);