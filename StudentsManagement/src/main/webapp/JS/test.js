const ascending = false;
const sortQuotes = (quotes, ascending) => {
    return quotes.sort((quoteA, quoteB) => {
        if (ascending) {
            return quoteA.id > quoteB.id ? 1 : -1;
        } else {
            return quoteA.id < quoteB.id ? 1 : -1;
        }
    });
};

class quotes {
    sort(x) {
        if (x = 1)
            return 'data sorted';
        else
            return 'data is not sorted '
    }
}

console.log(sortQuotes);