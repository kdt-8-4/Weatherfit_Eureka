var express = require('express');
var path = require('path');
var cookieParser = require('cookie-parser');
var logger = require('morgan');
var indexRouter = require('./routes/index');
var usersRouter = require('./routes/users');

var app = express();

app.use(logger('dev'));
app.use(express.json());
app.use(express.urlencoded({ extended: false }));
app.use(cookieParser());
app.use(express.static(path.join(__dirname, 'public')));

app.use('/', indexRouter);
app.use('/users', usersRouter);

const Eureka = require('eureka-js-client').Eureka;

const client = new Eureka({
   // Eureka 서버의 설정
   eureka: {
      host: '13.124.197.227',  // Eureka 서버의 주소
      port: 8761,  // Eureka 서버의 포트
      servicePath: '/eureka/apps/'
   },
   instance: {
      instanceId : 'nodejs-service',
      app: 'nodejs-service',  // 서비스의 이름
      ipAddr: '52.79.92.21',  // 서비스의 IP 주소
      port: {
         '$': 8003,  // 서비스의 포트
         '@enabled': 'true',
      },
      vipAddress: 'nodejs-service',  // 서비스의 VIP 주소
      statusPageUrl: 'http://52.79.92.21:8003',  // 서비스의 상태 페이지 URL
      healthCheckUrl: 'http://52.79.92.21:8003/health',  // 서비스의 헬스 체크 URL
      dataCenterInfo: {
         '@class': 'com.netflix.appinfo.InstanceInfo$DefaultDataCenterInfo',
         name: 'MyOwn',
      },
   },
});
app.get('/health', (req, res) => {
   res.json({status: 'UP'});
});

app.get('/nodetest', (req, res)=> {
   res.json({ check : 'check' });
})
client.start();  // Eureka 서버에 서비스를 등록
app.listen(8003, ()=> {
   console.log('localhost:8003');
});
module.exports = app;
