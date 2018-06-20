
##Run Project

mvn clean spring-boot:run

curl -XPOST -H "content-type: application/json"   -d '{"clientId":"0","counter":"12","type":"DEPOSIT","description":"NEW DEPOSIT", "amount":"5.11"}'  http://localhost:8080/add

curl -XPOST -H "content-type: application/json"   -d '{"clientId":"0","counter":"13","type":"DEPOSIT","description":"NEW DEPOSIT", "amount":"74.11"}'  http://localhost:8080/add


Get(Ref("classes/main_ledger/202584645080973824"))

CreateIndex(
    {
      name: "lall",
      source: Class("main_ledger")
    })

CreateIndex(
    {
      name: "lbi",
      source: Class("main_ledger"),
      terms: [{ field: ["data", "clientId"] }],
      values: [{ field: ["data", "counter"], reverse:true }, { field: ["ref"] }],
      unique: true
    })


CreateIndex(
    {
      name: "lbi4",
      source: Class("main_ledger"),
      terms: [{ field: ["data", "clientId"] }],
      values: [{ field: ["data", "counter"] }, { field: ["ref"] }],
      unique: true,
      serialized: true
    })

CreateIndex(
    {
      name: "lbi5",
      source: Class("main_ledger"),
      terms: [{ field: ["data", "clientId"] }],
      values: [{ field: ["data", "counter"] }, { field: ["ref"] }],
      unique: true
    })


Update(Index("lbi"), { "serialized": true })

Get(Ref("indexes/ledger_index_client_id"))
Paginate(Match(Index("ledger_index_client_id"), 0))
Paginate(Match(Index("lbi"), 0))

Get(Match(Index("lbi"), 0))

Get(Match(Index("lbi"), 0))

Paginate(Match(Index("lbi"), 0))

Select("data",
    Map(
        Paginate(
            Match(Index("ledger_index_client_id"), 202)
        ),
        Lambda("ref", Get(Var("ref")))
        )
    )

Select("data",
    Map(
        Paginate(
            Match(Index("ledger_index_client_id"), 202)
        ),
        Lambda(["counter","ref"], Get(Var("ref")))
        )
    )

SelectAll(["data", "data"],
    Map(
        Paginate(
            Match(Index("lbi"), 0)
        ),
        Lambda("ref", Get(Var("ref")))
        )
    )

CreateIndex(
    {
      name: "lci3",
      source: Class("main_ledger"),
      terms: [{ field: ["data", "clientId"] }],
      values: [{ field: ["data", "counter"] }, { field: ["data", "amount"] }, { field: ["ref"] }]
    })

Get(Ref("indexes/lci"))

Paginate(Match(Index("ledger_index_client_id"), 0))

SelectAll(["data"],
Map(
    Paginate(
        Match(Index("lci3"), 0)
    ),
    Lambda(["cntr","amount","ref"], Get(Var("ref")))
    )
    )


SelectAll(["data", "data"],
    Map(
        Paginate(
            Match(Index("lci3"), 0)
        ),
        Lambda("ref", Get(Var("ref")))
        )
    )



CreateIndex(
    {
      name: "lall",
      source: Class("main_ledger")
    })

Get(Ref("indexes/lall"))

Paginate(Match(Index("lall"))

 SelectAll(Path("data", "id"),
                Paginate(
                    Match(Index("lall"))
                ))

Get(Ref("classes/main_ledger/202584645080973824"))

Get(Ref("indexes/ledger_index_client_id"))

 Paginate(Match(Index("lbi"), 0))

 ObjectV({ref=RefV(id = "202584645080973824",
 class = RefV(id = "main_ledger", class = RefV(id = "classes"))),
 ts=LongV(1529458622898942),
 data=ObjectV({amount=DoubleV(42.11), clientId=LongV(0),
 description=StringV(NEW DEPOSIT), counter=LongV(1), type=StringV(DEPOSIT)})})


CreateIndex(
    {
      name: "people_by_name",
      source: Class("people"),
      terms: [{ field: ["data", "name"] }],
      unique: true
    })


Let(
    {
      refs: Select(
        "ref",
        Get(Match(Index("lbi2"), 0)))
    },
    Var("refs")
    )

Let(
    {
      refs:
        Paginate(Match(Index("lbi"), 0))
    },
    Select("data",Var("refs"))
    )


Map(
    Let(
        {
          refs:
            Paginate(Match(Index("lbi"), 0))
        },
        Select([0,1],Var("refs"))
    ),
    Lambda("x",Get(Var("x")))
    )


Get(Select([0,1],Paginate(Match(Index("lbi"), 0))))
