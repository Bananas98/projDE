
const webpack = require('webpack');
const path = require('path');
const HtmlWebpackPlugin = require('html-webpack-plugin');

const merge = require('webpack-merge');
const baseConfig = require('./webpack.base');

module.exports = merge(baseConfig,{
    mode: 'production',
    devtool: false,
    entry:'./index.js',
    output:{
        filename:'bundle.js',
        path:path.join(__dirname,'dist')
    },
    plugins:[
        new webpack.optimize.UglifyJsPlugin({
            include: /\.min\.js$/,
            minimize: true
        })
    ]

});