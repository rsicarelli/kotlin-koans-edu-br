function failWithWrongAge(age) {
    throw new Error("Wrong age: " + age);
}

function checkAge(age) {
    if (age === null || age < 0 || age > 150) {
        failWithWrongAge(age);
    } else {
        console.log("Congrats! Next year you'll be " + (age + 1));
    }
}

checkAge(10);
