const path = require('path');
const HTMLWebpackPlugin = require('html-webpack-plugin');
const {CleanWebpackPlugin} = require('clean-webpack-plugin');

module.exports = {
    mode: 'development',
    entry: './src/js/index.js',
    output: {
        publicPath: '/',
        filename: 'bundle.js',
        path: path.resolve(__dirname,'dist')
    },
    devServer: {
        historyApiFallback: true,
        proxy: {
            '/api': 'http://localhost:8080'
        },
        port: 8080,
        open: true
    },
    plugins: [
        new HTMLWebpackPlugin({
            title: 'Development page',
            template: './index.html'
        }),
        new CleanWebpackPlugin()
    ]
};