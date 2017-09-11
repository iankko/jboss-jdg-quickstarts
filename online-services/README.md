online-services: Example of using JDG Caching Service on OpenShift
==================================================================
Author: Sebastian Łaskawiec
Level: Intermediate
Technologies: Infinispan, OpenShift
Summary: The `online-services` quickstart demonstrates how to connect to a deployed JDG Online Services
Target Product: JDG
Product Versions: JDG 7.2

What is it?
-----------

The `online-services` quickstart demonstrates how to connecto to a deployed JDG Online Services.

Prerequisites
-------------

In order to run this project one needs to have an access to OpenShift installation with JDG Caching Service installed. Follow [the documentation](https://github.com/jboss-container-images/jboss-dataservices-image/tree/dataservices72-dev/caching-service) how to do it.

System requirements
-------------------

All you need to build this project is Java 8.0 (Java SDK 1.8) or better, Maven 3.0 or better and OpenShift 3 client.

Configure Maven
---------------

If you have not yet done so, you must [Configure Maven](https://github.com/jboss-developer/jboss-developer-shared-resources/blob/master/guides/CONFIGURE_MAVEN.md#configure-maven-to-build-and-deploy-the-quickstarts) before testing the quickstarts.

Build the Quickstart
--------------------

Type this command to build the quickstart:

        mvn clean package

Run the Quickstart
------------------

Run the following command

        mvn fabric8:run

This will deploy this service into OpenShift and connect to a default deployed Online Service. The plugin uses already configured and connected
 `oc` client, so make sure you are already authenticated and proper Project has been selected.

NOTE: Because of https://github.com/fabric8io/fabric8-maven-plugin/issues/1049[this issue] of Fabric8 Maven Plugin you won't see any logs. You need to manually find the pod (using `oc get pods`) and see the logs (using `oc logs ...`). This will be fixed in the near future.
