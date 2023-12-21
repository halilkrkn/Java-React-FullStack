// TODO: Variables, Rest, Spread, Destructure in JavaScript

let sayi1 = 25
sayi1 = "Halil İbrahim Karkın"
let student = {id: 1, name: "Halilkrkn"}

//console.log(student);

function save(puan = 10, ogrenci) {
    console.log(ogrenci.name + " : " + puan);
}

//save(undefined,student);

let students = ["Engin Demiroğ", " Halit Kalaycı", "Hazar Akatay", "Ali Veli"]

//console.log(students);

let students2 = [student, {id: 2, name: "Halit"}, "Ankara", {city: "İstanbul"}]
//console.log(students2);

//rest
//params
//varArgs
let showProducts = function (id, ...products) {
    console.log(id);
    console.log(products[0]);
}

//console.log(typeof showProducts)
//showProducts(10, "Elma", "Armut", "Karpuz")

//spread
let points = [1, 2, 3, 4, 50, 4, 60, 14]
console.log(...points);
console.log(Math.max(...points));
console.log(..."ABC", "D", ..."EFG", "H");

//Destructing
let populations = [10000, 20000, 30000, [40000, 100000]]
let [small, medium, high, [veryHigh, maximum]] = populations
console.log(small);
console.log(medium);
console.log(high);
console.log(veryHigh);
console.log(maximum);

function someFunction([small1], number) {
    console.log(small1);
}

someFunction(populations)

let category = {id: 1, name1: "İçecek"}
console.log(category.id);
console.log(category["name1"]);

let {id, name1} = category
console.log(id);
console.log(name1);