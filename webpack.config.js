const path = require('path');

module.exports = {
    mode: 'development',
    entry: './frontend/src/main/resources/js/index.js',
    output: {
        filename: 'bundle.js',
        path: path.resolve(__dirname,'dist')
    }
};