const path = require('path');
const webpack = require('webpack');
const HtmlWebpackPlugin = require('html-webpack-plugin');

module.exports = {
    mode: 'development',
    entry: './src/js/index.js',
    output: {
        publicPath: '/',
        filename: 'bundle.js',
        path: path.resolve(__dirname,'dist')
    },
    devtool:'eval',
    devServer: {
        historyApiFallback: true,
        proxy: {
            '/api': 'http://localhost:8080'
        },
        port: 9991,
        open: true
    },
    resolve: {
        extensions: ['.js'],
        alias: {
            rootDirectory: path.resolve(__dirname, './src'),
        },
    },
    module: {

        loaders: [{
            test: /\.js$/,
            exclude: /node_modules/,
            loaders: ['babel-loader',"eslint-loader"]
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
    plugins: [
        new HtmlWebpackPlugin({
            title:'Index',
            template:'./index.html'
        }),

        new webpack.NamedModulesPlugin(),
        new webpack.HotModuleReplacementPlugin(),
        new webpack.ProvidePlugin({
            $: 'jquery',
            jQuery: 'jquery',
            'window.$': 'jquery',
            'window.jQuery': 'jquery',
        }),
    ],
    externals: {
        jquery: 'jQuery',
    }
};