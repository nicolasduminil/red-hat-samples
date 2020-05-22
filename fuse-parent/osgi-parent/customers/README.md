# Customers OSGi
This is the OSGi implementation of the Customer Management application. It may 
be deployed in Apache Karaf 4.2.8 ot higher or on Red Hat Fuse 7.4 or higher 
supporting Java 11 LTS.

## Install the Oracle JDBC driver in Karaf
```
karaf@root()> bundle:install -s wrap:mvn:com.oracle.jdbc/ojdbc8/12.2.0.1
```
The command above will search the maven local repository for the given artifact, i.e. com.oracle.jdbc:ojdbc8:12.2.0.1:jar. If the local repository doesn't contain the artifact then it will be downloaded from the maven central.
Then, the "wrap" operator which prefixes the command will convert the maven artifact in an OSGi bundle. Finally the resulting bundle will be installed in Karaf.
## Register customers-features repo
Execute the command:
```
karaf@root()> feature:repo-add mvn:fr.simplex-software.red-hat.fuse.osgi/customers-features/0.0.1-SNAPSHOT/xml
```
then check wether the repo has installed correctly:
```
karaf@root()> feature:list | grep customers
customers-datasource                | 0.0.1.SNAPSHOT                  |          | Uninstalled | osgi-customers-features-0.0.1-SNAPSHOT        |
customers-data                      | 0.0.1.SNAPSHOT                  |          | Uninstalled | osgi-customers-features-0.0.1-SNAPSHOT        |
customers-service                   | 0.0.1.SNAPSHOT                  |          | Uninstalled | osgi-customers-features-0.0.1-SNAPSHOT        |
karaf@root()>
```
## Install the features in the customers-features repo
Install the datasource:
```
karaf@root()> feature:install customers-datasource
```
Install the customers data (entities, dtos)
```
karaf@root()> feature:install customers-data
