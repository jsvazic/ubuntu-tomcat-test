# Overview
This project is a sample application that uses an HSQLDB instance to demonstrate the need for Tomcat 7.0.27+ for Ubuntu when using Hibernate 4.1+.

## Configuration
Ensure that the `lib/hsqldb-1.8.0.10.jar` file is copied to the `/usr/share/tomcat7/lib` directory in Tomcat and then restart Tomcat before deploying the war file, i.e. `service tomcat7 restart`.

## Build and Deploy
Execute `mvn clean package` and then copy the resulting `ubuntu-test.war` file to `/var/lib/tomcat7/webapps`.

## Testing
Open a browser and browse to [http://localhost:8080/ubuntu-test].  If the page renders correctly then you are good to go.
