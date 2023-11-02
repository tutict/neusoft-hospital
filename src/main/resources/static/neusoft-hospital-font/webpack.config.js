const { VueLoaderPlugin } = require('vue-loader');
const path = require('path');
const { DefinePlugin } = require('webpack');

module.exports = {
    mode: 'development',  // 指定构建模式
    entry: './src/index.js',  // 指定入口文件
    output: {
        filename: 'bundle.js',
        path: path.resolve(__dirname, 'dist'),  // 指定输出目录
        publicPath: '/',
    },
    module: {
        rules: [
            {
                test: /\.vue$/,
                loader: 'vue-loader'
            },
            {
                test: /\.ts$/,
                loader: 'ts-loader',
                options: { appendTsSuffixTo: [/\.vue$/] },
            },
            {
                test: /\.(js|jsx)$/,
                exclude: /node_modules/,
                use: {
                    loader: 'babel-loader',
                    options: {
                        presets: ['@babel/preset-react'],
                    },
                },
            },
            {
                test: /\.css$/,
                use: ['style-loader', 'css-loader'],
            }
        ]
    },
    plugins: [
        new VueLoaderPlugin(),
        // ...你现有的插件...
        new DefinePlugin({
            __VUE_OPTIONS_API__: true, // or false, if you want to disable the options API
            __VUE_PROD_DEVTOOLS__: false, // should be false in production for security reasons
        }),
    ],
    resolve: {
        alias: {
            'vue': '@vue/runtime-dom' // 解析运行时构建+编译器
        },
        extensions: ['.vue', '.js', '.jsx']  // 允许在导入时省略.js和.jsx扩展名
    },
    devServer: {
        static: {
            directory: path.join(__dirname, 'public'),
        },
        devMiddleware: {
            publicPath: '/',
        },
        compress: true,
        port: 9000  // 指定开发服务器的端口
    }
};