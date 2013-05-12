basePath = '';

files = [
  ANGULAR_SCENARIO,
  ANGULAR_SCENARIO_ADAPTER,
  'e2e/**/*.js'
];

autoWatch = true;

browsers = ['Chrome'];

singleRun = false;

urlRoot = '/__karma/';

proxies = {
  '/': 'http://localhost:9000/'
};


reporters = ['progress', 'junit'];
junitReporter = {
    outputFile: '../../target/e2e-test-results.xml',
    suite: 'e2e'
};
