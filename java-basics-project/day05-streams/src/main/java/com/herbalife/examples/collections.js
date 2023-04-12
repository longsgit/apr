let numbers = [101, 120, 330, 408, 519, 876];
numbers
    .filter(e => {
        console.log("******* filter " + e);
        return e % 2 == 0;
    })
    .map(e => {
        console.log("******* map " + e);
        return e * e;
    });
    //.forEach(e => console.log(e));