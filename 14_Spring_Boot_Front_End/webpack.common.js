const path = require('path');

module.exports = {
  entry: {
    app: './js/placeOrder.js',
  },
  output: {
    path: path.resolve(__dirname, 'dist'),
    clean: true,
    filename: './js/placeOrder.js',
  },
};
