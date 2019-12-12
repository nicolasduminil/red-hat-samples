# red-hat-samples

## Install the Oracle JDBC driver in Karaf
```
karaf@root()> install wrap:file:C:/users/duminni/ojdbc8.jar
```
## Register customers-features repo
Execute the command:
```
karaf@root()> feature:repo-add mvn:fr.simplex-software.red-hat.fuse.osgi/customers-features/0.0.1-SNAPSHOT/xml
```
then check wether the repo has installed correctly:
```
karaf@root()> feature:list | grep customers
customers-datasource                | 0.0.1.SNAPSHOT                  |          | Uninstalled | osgi-customers-features-0.0.1-SNAPSHOT        |
customers-data                           | 0.0.1.SNAPSHOT                  |          | Uninstalled | osgi-customers-features-0.0.1-SNAPSHOT        |
customers-service                        | 0.0.1.SNAPSHOT                  |          | Uninstalled | osgi-customers-features-0.0.1-SNAPSHOT        |
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
```