
const webpack = require('webpack');
const path = require('path');
const HtmlWebpackPlugin = require('html-webpack-plugin');

module.exports={
    mode: 'production',
    devtool: false,
    context:path.join(__dirname,'src'),
    entry:'./index.js',
    output:{
        filename:'bundle.js',
        path:path.join(__dirname,'dist')
    },
    module: {

        loaders: [{
            test: /\.js$/,
            exclude: /node_modules/,
            loaders: ['babel-loader','eslint-loader']

        },
            { test: /vendor\/.+\.(jsx|js)$/,
                loader: 'imports?jQuery=jquery,$=jquery,this=>window'
            },
            {
                test: require.resolve('jquery-validation'),
                loader: 'imports-loader',
                query: 'define=>false,$=jquery',
            },
            { test:/bootstrap-sass[\/\\]assets[\/\\]javascripts[\/\\]/, loader: 'imports?jQuery=jquery' }
        ],


    },

    plugins:[
        new HtmlWebpackPlugin({
            title:'Index',
            template:'./index.html'
        }),


        new webpack.ProvidePlugin({
            $: 'jquery',
            jQuery: 'jquery',
            'window.$': 'jquery',
            'window.jQuery': 'jquery',
        }),
        new webpack.optimize.UglifyJsPlugin({
            include: /\.min\.js$/,
            minimize: true
        })
    ],

};