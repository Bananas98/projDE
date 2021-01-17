import * as webpack
    from "../../../../.IntelliJIdea2019.3/config/javascript/extLibs/codota-types/webpack/3.8.20/@types/webpack";

const path = require('path');
const HTMLWebpackPlugin = require('html-webpack-plugin');
const {CleanWebpackPlugin} = require('clean-webpack-plugin');

module.exports = {
    context: path.resolve(__dirname, 'src'),
    entry: './src/js/index.js',
    devServer: {
        historyApiFallback: true,
        proxy: {
            '/': 'http://localhost:8080'
        },
        port: 9991,
        open: true
    },
    plugins: [
        new HTMLWebpackPlugin({
            title: 'Index',
            template: './index.html'
        }),
        new CleanWebpackPlugin(),
        new webpack.ProvidePlugin({
            $: 'jquery',
            jQuery: 'jquery',
            'window.$': 'jquery',
            'window.jQuery': 'jquery',
        }),
    ],
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
    }

};