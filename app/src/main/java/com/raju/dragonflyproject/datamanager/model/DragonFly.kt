package com.raju.dragonflyproject.datamanager.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DragonFly(val id: String, val name: String, val description: String,
                     val images: ArrayList<Images>, val location: AddressLocation,
                     val date: String, val comments: ArrayList<Comments>) : Parcelable

/*  {
    "id": "59d2bd5a2b92b0ceeed8eec7",
    "name": "esse enim",
    "description": "Excepteur cillum deserunt non deserunt ipsum aliqua nostrud fugiat. Qui ullamco fugiat sit adipisicing nostrud proident cillum voluptate. In sunt eu elit deserunt velit. Anim qui occaecat consectetur pariatur aliquip minim aute mollit dolore exercitation laboris anim id. Deserunt et laboris nostrud consequat Lorem do adipisicing. Laboris aute deserunt labore non consectetur dolore laboris Lorem est est. Ad et id do do.\r\n",
    "images": [
      {
        "id": "uHAis0T+SuSywBdWX0j+UQ==",
        "caption": "Tempor culpa ipsum minim ullamco sint irure irure occaecat minim in pariatur ut."
      },
      {
        "id": "fCRkaFSvTyGei8zSX6WB4A==",
        "caption": "Incididunt minim culpa amet tempor fugiat mollit amet anim consequat ea eiusmod nulla."
      },
      {
        "id": "qkNVaP/zSI6VpGc0zXrCfQ==",
        "caption": "Duis officia nisi fugiat fugiat."
      },
      {
        "id": "mH9HD5ScTSqqi8WFUsvoGA==",
        "caption": "Lorem nisi exercitation dolor eiusmod duis."
      },
      {
        "id": "ScOOJk5DQoqvr6Ne+KRvIw==",
        "caption": "Ut nisi aute amet duis officia consequat laborum mollit aliqua."
      },
      {
        "id": "6jCHpbaRTN6SUodg95TctA==",
        "caption": "Sint est est ullamco dolor."
      }
    ],
    "location": {
      "name": "Incubus",
      "address": "4792 Herzl Street",
      "city": "Blende",
      "state": "Virgin Islands"
    },
    "date": "2017-10-02T05:27:38+05:00",
    "comments": [
      {
        "from": "Dona Jefferson",
        "text": "Est irure adipisicing duis esse ex culpa do non adipisicing nisi. Excepteur irure ipsum ut do deserunt fugiat Lorem anim. Excepteur dolore exercitation est adipisicing occaecat adipisicing deserunt nostrud et aute reprehenderit irure laboris. Est non esse qui aute officia officia deserunt exercitation consectetur fugiat qui nisi. Excepteur sint voluptate ipsum deserunt nisi nisi. Ea adipisicing laboris labore ut velit magna proident ex. Labore commodo ea fugiat fugiat ipsum eiusmod labore deserunt cillum tempor ullamco exercitation nisi.\r\n"
      },
      {
        "from": "Olson Powers",
        "text": "Reprehenderit dolore veniam voluptate cillum nostrud nostrud sint esse quis excepteur ipsum ad. Eu et consequat proident id duis anim adipisicing cupidatat minim qui ea labore ipsum. Cupidatat magna est consectetur dolore velit non eu quis velit enim reprehenderit commodo in. Minim proident mollit id ex deserunt nulla.\r\n"
      },
      {
        "from": "Jacklyn Cameron",
        "text": "Commodo velit fugiat duis culpa est officia. Eiusmod et ex consectetur et deserunt incididunt et sunt qui aute velit amet cillum. Incididunt irure laboris eu irure esse occaecat ex aliquip culpa.\r\n"
      },
      {
        "from": "Lenora Oconnor",
        "text": "Consequat dolor qui eiusmod consectetur ut et dolore minim mollit cillum exercitation elit ea. Irure ut nostrud consectetur commodo non aliquip consectetur consectetur officia ex occaecat consectetur. Lorem fugiat esse officia anim consectetur aute anim nulla. Labore consectetur ad deserunt adipisicing cillum fugiat magna.\r\n"
      },
      {
        "from": "Hope Chavez",
        "text": "Est magna adipisicing tempor commodo non adipisicing eiusmod ut excepteur. Fugiat ea sunt ipsum eu do duis consectetur ea consectetur cillum duis Lorem. Do tempor anim deserunt mollit ipsum sit laboris eiusmod fugiat irure.\r\n"
      },
      {
        "from": "Wilder Higgins",
        "text": "Ullamco elit sunt dolor officia. Officia reprehenderit Lorem excepteur qui occaecat amet aliquip nostrud esse sit esse et. Lorem amet aliqua do sit nulla cillum esse ut incididunt tempor commodo duis velit. Laboris consectetur duis sunt laboris qui minim magna. Lorem duis ea anim dolor labore voluptate. Aliquip cupidatat aliquip adipisicing officia consectetur.\r\n"
      },
      {
        "from": "Twila Cohen",
        "text": "Cupidatat nostrud tempor sit minim cupidatat veniam non id nostrud id. Adipisicing culpa aliqua pariatur dolor ut aliquip eiusmod excepteur ex proident reprehenderit velit. Deserunt incididunt laboris exercitation tempor ex occaecat do voluptate ea non eiusmod pariatur. Incididunt voluptate anim ad minim consequat sit voluptate culpa reprehenderit qui officia. Irure excepteur duis et consequat cillum anim officia pariatur non sint magna irure.\r\n"
      },
      {
        "from": "Rollins Acosta",
        "text": "Eu tempor incididunt enim veniam minim incididunt aliqua do duis ipsum consequat non exercitation. Consectetur sit ea enim reprehenderit officia. Nulla ex tempor ipsum nulla deserunt est deserunt cupidatat excepteur esse. Non sunt reprehenderit pariatur eu velit ex occaecat proident nostrud ipsum aute. Exercitation cillum officia ea ex nisi id tempor nisi ea sit.\r\n"
      },
      {
        "from": "Maxwell Rice",
        "text": "Lorem laboris eu cillum exercitation. Tempor sunt ipsum adipisicing amet tempor dolor amet fugiat. Fugiat reprehenderit magna excepteur tempor culpa ullamco nisi. Magna officia ea reprehenderit fugiat culpa quis. Nisi duis enim minim consectetur ullamco sint dolor nisi et sint ullamco veniam. Occaecat nisi aute adipisicing officia eu. Reprehenderit enim non non sint incididunt consequat enim voluptate ullamco.\r\n"
      },
      {
        "from": "Conrad Battle",
        "text": "Cillum amet Lorem cillum cupidatat incididunt cupidatat et ullamco occaecat ex enim. Eiusmod culpa qui amet aliquip minim quis anim voluptate. Mollit magna irure reprehenderit incididunt consequat consectetur irure ea officia Lorem id enim.\r\n"
      }
    ]
  },
  */