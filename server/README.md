
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
      name: "UNIQUE_ENTRY_CONSTRAINT",
      source: Class("main_ledger"),
      terms: [{ field: ["data", "clientId"] }],
      values: [{ field: ["data", "counter"], reverse:true }, { field: ["ref"] }],
      unique: true
    })


CreateIndex(
    {
      name: "UNIQUE_ENTRY_CONSTRAINT",
      source: Class("main_ledger"),
      terms: [{ field: ["data", "clientId"] }],
      values: [{ field: ["data", "counter"] }],
      unique: true
    })


CreateIndex(
    {
      name: "ledger_index_client_id",
      source: Class("main_ledger"),
      terms: [{ field: ["data", "clientId"] }],
      values: [{ field: ["data", "counter"], reverse:true }, { field: ["ref"] }],
      unique: false,
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

Create(Class("ledger_class"),
              { data: {"clientId":50,"counter":0,"type":"DEPOSIT","description":"NEW DEPOSIT", "amount":28.19} })
Create(Class("ledger_class"),
              { data: {"clientId":50,"counter":1,"type":"DEPOSIT","description":"NEW DEPOSIT", "amount":58.19} })
Create(Class("ledger_class"),
              { data: {"clientId":50,"counter":2,"type":"DEPOSIT","description":"NEW DEPOSIT", "amount":21.19} })
Create(Class("ledger_class"),
              { data: {"clientId":50,"counter":3,"type":"DEPOSIT","description":"NEW DEPOSIT", "amount":32.19} })
Create(Class("ledger_class"),
              { data: {"clientId":50,"counter":4,"type":"DEPOSIT","description":"NEW DEPOSIT", "amount":11.09} })

Select(["data", "counter"], Create(Class("ledger_class"),{ data: {"clientId":0,"counter":21,"type":"DEPOSIT","description":"NEW DEPOSIT", "amount":28.19} }))

Update(Index("lbi"), { "serialized": true })

Get(Ref("indexes/UNIQUE_ENTRY_CONSTRAINT"))
Get(Ref("indexes/ledger_index_client_id"))
Paginate(Match(Index("ledger_index_client_id"), 50))
Paginate(Match(Index("lbi"), 0))

Get(Match(Index("spells_index")))

Get(Match(Index("lbi"), 0))

Get(Match(Index("lbi"), 0))

Paginate(Match(Index("ledger_index_client_id"), 0))


SelectAll(["data","data"],
    Map(
        Paginate(
            Match(Index("lall"))
        ),
        Lambda("ref", Get(Var("ref")))
        )
    )



Select("data",
    Map(
        Paginate(
            Match(Index("ledger_index_client_id"), 0)
        ),
        Lambda("ref", Get(Var("ref")))
        )
    )

SelectAll(["data","data"],
    Map(
        Paginate(
            Match(Index("ledger_index_client_id"), 0)
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


Create(Class("ledger_class"),
               { data: {"clientId":52,"counter":0,"type":"DEPOSIT","description":"NEW DEPOSIT", "amount":28.19} })


Select(["data", "counter"], Create(Class("main_ledger"),
  { data: {"clientId":52,"counter":20,"type":"DEPOSIT","description":"NEW DEPOSIT", "amount":28.19} }))

Get(Ref(Class("main_ledger"), "202659774909645312"))

Paginate(Match(Index("UNIQUE_ENTRY_CONSTRAINT"), 0))
Paginate(Match(Index("ledger_index_client_id"), 0))

SelectAll(["data","counter"],
    Get(
        Select([0,1],
        Paginate(Match(Index("ledger_index_client_id"), 0)))
    )
)

Select([0,1],
             Paginate(Match(Index("ledger_index_client_id"), 0))
)

Let(
    {latest: Add(
        Select([0,0],
            Paginate(Match(Index("ledger_index_client_id"), 0)),0
         ),1),
      counter: 19
    },
    Var("latest")
    )


Let(
    {latest: Add(
        Select([0,0],
            Paginate(Match(Index("ledger_index_client_id"), 0)),0
         ),1),
      counter: 1
    },
    If(Equals(Var("counter"), Var("latest")),
        ["saved",
            Select(["data", "counter"], Create(Class("main_ledger"),
              { data: {"clientId":0,"counter":1,"type":"DEPOSIT","description":"NEW DEPOSIT", "amount":28.19} }))
        ],
        ["not_saved",Var("latest")]
        )
)

 If(Equals(20, 20),
        ["saved", 21],
        ["not_saved",20]
        )

If(true, "was true", "was false"))


CreateIndex(
    { name: "posts_by_tags_with_title",
      source: Class("spells"),
      terms: [{ field: ["data", "tags"] }],
      values: [{ field: ["data", "title"] }] })
