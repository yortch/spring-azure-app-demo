# Run Java 21 app in Azure Spring Apps

This sample shows how to run Java 21 app in `Azure Spring Apps` with health/metrics endpoints enabled.

### Prerequisite

* [JDK 21](https://docs.microsoft.com/azure/java/jdk/java-jdk-install)
* [Maven 3.0 and above](http://maven.apache.org/install.html)
* [Azure CLI](https://docs.microsoft.com/cli/azure/install-azure-cli?view=azure-cli-latest) or [Azure Cloud Shell](https://docs.microsoft.com/azure/cloud-shell/overview)

### How to run 

1. Run `mvn clean package` under `spring-azure-app-demo`.
1. Install Azure CLI extension for Azure Spring Apps by running below command.
    ```bash
    az extension add --name spring
    ```
1. Create an instance of Azure Spring Apps.
    ```bash
    az spring create -n <service name> -g <resource group name>
    ```
1. Create an app with public domain assigned.
    ```bash
    az spring app create -n <app name> -s <resource name> -g <resource group name> --runtime-version Java_11 --is-public true 
    ```
1. Deploy app with jar
    ```bash
    az spring app deploy -n <app name> -s <resource name> -g <resource group name> --artifact-path ./target/hello-world-az-spring-app-1.0-SNAPSHOT.jar
    ```
1. Verify app is running. Instances should have status `RUNNING` and discoveryStatus `UP`. 
    ```bash
    az spring app show -n <app name> -s <resource name> -g <resource group name>
    ```
1. Verify sample is working. The url is fetch from previous step. 
    ```bash
    curl {url}/hello/{name}
    Hello {name}
    ```
