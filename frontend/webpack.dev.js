const path = require('path');
const webpack = require('webpack');
const HtmlWebpackPlugin = require('html-webpack-plugin');
const merge = require('webpack-merge');
const baseConfig = require('./webpack.base');

module.exports = merge(baseConfig,{
    mode: 'development',
    entry: './src/js/index.js',
    output: {
        publicPath: '/',
        filename: 'bundle.js',
        path: path.resolve(__dirname,'dist')
    },
    devtool:'eval',

    resolve: {
        extensions: ['.js'],
        alias: {
            rootDirectory: path.resolve(__dirname, './src'),
        },
    },
    plugins: [
        new webpack.NamedModulesPlugin(),
        new webpack.HotModuleReplacementPlugin(),
    ],
    externals: {
        jquery: 'jQuery',
    }
});