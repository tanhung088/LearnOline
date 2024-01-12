function highlight([first, ...value], ...rest) {
    return rest.reduce(
        (rs, item) => [...rs, `<span>${item}</span>`,value.shift()],
        [first]
    );
}
var courses = {
    name: "HTML & CSS",
    brand: "F8",
    price: 1300000,
};
var html = highlight`Khóa học ${courses.name} tại ${courses.brand} có giá là: ${courses.price}!`;
console.log(html.join(''));