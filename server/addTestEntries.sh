#!/bin/bash

echo "Adding First Batch of Entries to client 0"

curl -XPOST -H "content-type: application/json"   -d '{"clientId":"0","counter":"10","type":"DEPOSIT","description":"NEW DEPOSIT", "amount":"42.11"}'  http://localhost:8080/add
curl -XPOST -H "content-type: application/json"   -d '{"clientId":"0","counter":"11","type":"WITHDRAWL","description":"NEW DEPOSIT", "amount":"32.10"}'  http://localhost:8080/add
curl -XPOST -H "content-type: application/json"   -d '{"clientId":"0","counter":"12","type":"DEPOSIT","description":"NEW DEPOSIT", "amount":"142.9"}'  http://localhost:8080/add
curl -XPOST -H "content-type: application/json"   -d '{"clientId":"0","counter":"13","type":"DEPOSIT","description":"NEW DEPOSIT", "amount":"242.2"}'  http://localhost:8080/add
curl -XPOST -H "content-type: application/json"   -d '{"clientId":"0","counter":"14","type":"WITHDRAWL","description":"NEW DEPOSIT", "amount":"72.54"}'  http://localhost:8080/add
curl -XPOST -H "content-type: application/json"   -d '{"clientId":"0","counter":"15","type":"WITHDRAWL","description":"NEW DEPOSIT", "amount":"92.68"}'  http://localhost:8080/add
curl -XPOST -H "content-type: application/json"   -d '{"clientId":"0","counter":"16","type":"DEPOSIT","description":"NEW DEPOSIT", "amount":"12.81"}'  http://localhost:8080/add
curl -XPOST -H "content-type: application/json"   -d '{"clientId":"0","counter":"17","type":"WITHDRAWL","description":"NEW DEPOSIT", "amount":"43.61"}'  http://localhost:8080/add
curl -XPOST -H "content-type: application/json"   -d '{"clientId":"0","counter":"18","type":"DEPOSIT","description":"NEW DEPOSIT", "amount":"58.79"}'  http://localhost:8080/add

echo "Adding Second Batch of Entries to client 2"

curl -XPOST -H "content-type: application/json"   -d '{"clientId":"0","counter":"0","type":"WITHDRAWL","description":"NEW DEPOSIT", "amount":"92.11"}'  http://localhost:8080/add
curl -XPOST -H "content-type: application/json"   -d '{"clientId":"0","counter":"1","type":"DEPOSIT","description":"NEW DEPOSIT", "amount":"82.10"}'  http://localhost:8080/add
curl -XPOST -H "content-type: application/json"   -d '{"clientId":"0","counter":"2","type":"WITHDRAWL","description":"NEW DEPOSIT", "amount":"742.9"}'  http://localhost:8080/add
curl -XPOST -H "content-type: application/json"   -d '{"clientId":"0","counter":"3","type":"WITHDRAWL","description":"NEW DEPOSIT", "amount":"42.2"}'  http://localhost:8080/add
curl -XPOST -H "content-type: application/json"   -d '{"clientId":"0","counter":"4","type":"DEPOSIT","description":"NEW DEPOSIT", "amount":"272.54"}'  http://localhost:8080/add
curl -XPOST -H "content-type: application/json"   -d '{"clientId":"0","counter":"5","type":"WITHDRAWL","description":"NEW DEPOSIT", "amount":"392.68"}'  http://localhost:8080/add
curl -XPOST -H "content-type: application/json"   -d '{"clientId":"0","counter":"6","type":"DEPOSIT","description":"NEW DEPOSIT", "amount":"212.81"}'  http://localhost:8080/add
curl -XPOST -H "content-type: application/json"   -d '{"clientId":"0","counter":"7","type":"WITHDRAWL","description":"NEW DEPOSIT", "amount":"3.61"}'  http://localhost:8080/add
curl -XPOST -H "content-type: application/json"   -d '{"clientId":"0","counter":"8","type":"DEPOSIT","description":"NEW DEPOSIT", "amount":"88.79"}'  http://localhost:8080/add


echo "Reading all entries"

curl http://localhost:8080/all&clientid=0