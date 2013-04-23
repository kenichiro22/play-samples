Running Play2 application on Amazon Elastic Beanstalk
=====================================

<a href="https://github.com/dlecan/play2-war-plugin">play2-war-plugin</a>を使用して作成したwarファイルを
Amazon Elasticbeanstalk環境でPlay2アプリケーションを動作させるサンプルです。

## カスタマイズ

Elastic Beanstalkをカスタマイズする場合には、WEB-INFディレクトリに.ebextensionsというディレクトリを作成し、
その中に設定ファイルを作成します。

Play2 warプラグインを使用する場合には、プロジェクトのホームディレクトリにwar/WEB-INF/.ebextensionsを作成します。

#### 参考

* [Customizing and Configuring AWS Elastic Beanstalk Environments - AWS Elastic Beanstalk](http://docs.aws.amazon.com/elasticbeanstalk/latest/dg/customize-containers.html)
* [Customizing the Software on EC2 Instances Running Linux - AWS Elastic Beanstalk](http://docs.aws.amazon.com/elasticbeanstalk/latest/dg/customize-containers-ec2.html)

### Java7を使用する

Java7(OpenJDK)を使用する場合には、.ebextensionsディレクトリに以下の内容でjava7.configというファイルを作成します。

    packages:
      yum:
        java-1.7.0-openjdk: []
        java-1.7.0-openjdk-devel: []

    commands:
      use_java7:
        command: alternatives --set java /usr/lib/jvm/jre-1.7.0-openjdk.x86_64/bin/java

#### 参考

* [Using Java 1.7 on Amazon AWS Elastic Beanstalk — Quinn Slack](http://qslack.com/2012/12/using-java-1-7-on-amazon-aws-elastic-beanstalk/)