# AWS Neptune demo application

### How to deploy this demo app

###### prerequisites:
* AWS account
* [AWS cli](https://docs.aws.amazon.com/cli/latest/userguide/cli-chap-install.html)
* [AWS SAM cli](https://docs.aws.amazon.com/serverless-application-model/latest/developerguide/serverless-sam-cli-install.html)
* Java 8
* Maven

###### deployment steps:
* create an AWS Neptune instance:
    * go to [AWS Neptune home](https://console.aws.amazon.com/neptune/home)
    * click "Launch Amazon Neptune"
    * select DB engine version and DB instance class
    * enable or disable high availability (Multi-AZ)
    * enter a DB instance identifier in the "Settings" section
    * click "Next"
    * select VPC, subnet group and availability zone
    * leave "Create new VPC security group" checked
    * leave other parameters as default and click "Create Database" below
    * it will take some time (ca. 7 min) for the instance to start and become available
* adjust the created Neptune's security group:
    * go to the [security groups](https://console.aws.amazon.com/ec2/v2/home#SecurityGroups:sort=groupId)
    * find the newly created security group. it should have the name "rds-launch-wizard" or similar.
    * write down the security group ID
    * add a new inbound rule allowing all incoming TCP connections from **inside** the security group:
        * Type = Custom TCP
        * Protocol = TCP
        * Port Range = 0 - 65535
        * Source = < ID of the security group >
* create an S3 bucket. AWS SAM will use it for storing lambdas (ZIP archives).
* create an IAM role for lambdas. The role should have the following (predefined by AWS) policies:
    * [AWSLambdaBasicExecutionRole](https://console.aws.amazon.com/iam/home#/policies/arn:aws:iam::aws:policy/service-role/AWSLambdaBasicExecutionRole$jsonEditor)
    * [AWSLambdaVPCAccessExecutionRole](https://console.aws.amazon.com/iam/home#/policies/arn:aws:iam::aws:policy/service-role/AWSLambdaVPCAccessExecutionRole$jsonEditor)
* build and deploy lambdas:
    * `cd cloudformation`
    * `cp vars.template.sh vars.sh`
    * `vi vars.sh`
    * adjust the variables:
        * `S3_BUCKET` -- name of the created S3 bucket where lambdas will be stored.
        * `STACK_NAME` -- name that will be used for the CloudFormation stack with lambdas.
        * `ROLE_ARN` -- ARN of the created IAM role for lambdas.
        * `SECURITY_GROUP_IDS` -- the ID of the security group created for Neptune.
        * `SUBNET_IDS` -- IDs of the subnets of the VPC where the Neptune instance has been deployed.
        * `NEPTUNE_ENDPOINT` -- Neptune's endpoint. It can be found in the [Neptune clusters](https://console.aws.amazon.com/neptune/home#dbclusters:). Click on the created cluster and find the "Cluster endpoint" DNS name in the "Details" section.
        * `NEPTUNE_PORT` -- Neptune's port (8182 by default).
        * `TAG_USER` -- user name for marking AWS resources with tag `user`.
    * build and deploy lambdas: `. build.sh && . package.sh && . deploy.sh`
* go to the [CloudFormation home](https://console.aws.amazon.com/cloudformation/home#/stacks?filter=active) and observe that a new stack with lambdas appeared
* wait for the stack to be ready
* go to the [AWS Lambda Functions](https://console.aws.amazon.com/lambda/home#/functions) and observe 2 AWS functions

### Loading test data
Loading test data

### Executing test query
test ad hoc query 1:
```json
{
  "skill1": "Java EE 8",
  "skill2": "PostgreSQL",
  "skill3": "TDD",
  "certificate": "OCP Java SE 8",
  "customer": "Big Brother Corporation",
  "availableFrom": 1516492800000,
  "availableTo": 1516665600000
}
```

result:
```json
[
  {
    "firstName": [
      "Bob"
    ],
    "lastName": [
      "Smith"
    ],
    "id": [
      10
    ],
    "position": [
      "software engineer"
    ]
  }
]
```

test ad hoc query 2:
```json
{
  "skill1": "Java EE 8",
  "skill2": "PostgreSQL",
  "skill3": "TDD",
  "certificate": "OCP Java SE 8",
  "customer": "Space Logistics AG",
  "availableFrom": 1514764800000,
  "availableTo": 1517443200000
}
```

result:
```json
[
  {
    "firstName": [
      "Alice"
    ],
    "lastName": [
      "Brown"
    ],
    "id": [
      20
    ],
    "position": [
      "senior software engineer"
    ]
  },
  {
    "firstName": [
      "Bob"
    ],
    "lastName": [
      "Smith"
    ],
    "id": [
      10
    ],
    "position": [
      "software engineer"
    ]
  }
]
```
