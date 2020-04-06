# JobPortalWebService
JobPortalWebService
> # DATABASE
>>  create database JobWebService;

> # SOME ISSUES

>> update needs to **Collection Handlling features Comparator**





>>> [ Skills,Resume,Education ]

>> cascade=CascadeType.ALL with Skills,Resume,Education 

>>> it's **delete the whole record with jobSeeker** when remove the Education or Skills or Resume.

>> we  not able to *fetch the details* of the of all **The JOBSeekers who have Skill of JAVA or One Particular Constraint**
>>> we Should Implement the **Mapping in Both POJO** but its gives **Serialisation Error** so I not Implement that.

>> In Job Description lenght is less so we need to Increase




># JSON DATA FEEDING FORMAT

>>## EducationCategory

>>>1. Add/Update 

```
{
	"text":"10th"
}

```



>>## JobSeeker

>>1. Add/Update

```
	{
	"firstname": "Deepanshu",
	  "lastname": "Gupta",
	  "location": "New Delhi",
	"address": "2558/194 Onkar nagar",
	  "dob": "10/02/1997",
	"email":"deepanshujindal1021997@gmail.com",
	"password":"123"
	}


```

>>>### Education

>>>>1. Addition/Update

```
{
		"catname":"10th",
		"course":"10",
		"courseType":"Regular",
		"specialisation":"Genral",
	 "university":"S.K.V No-2",
	"passingYear":"2014"
}

```


>>>### Resume

```
{
	"filename":"FileName",
"fileType":"FileType"
}

```
>>>### Skills

```
{
	"name":"Python",
	"type":"Basics"
}

```
>>## Recruiter

```
{
 "companyAddress": "Greater Noida",
    "description": "MNC ",
    "companyName": "NIIT TECHNOLOGIES LTD",
    "companyType": "IT",
     "email": "deep123@gmail.com",
      "firstName": "Deepanshu",
      "lastName": "Gupta",
      "password": "123"
   }

```

>>>### JOB Posting
```
{
        "advertiseDate": "2020-01-10",
        "descriptions": "string",
        "expDate": "2020-30-10",
        "jobTitle": "Application Developer - Java Full Stack",
        "offerSalary": "Not disclose",
        "type": "IT",
        "vacancy": "50",
	"experience":"fresher"
}
```
