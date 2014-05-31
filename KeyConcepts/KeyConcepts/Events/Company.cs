using System;
using System.Collections.Generic;
using System.Linq;

namespace Events {
    public class Company {
        public event EventHandler<LookForEventArgs> LookForPeople;

        public string Name { get; set; }
        public List<Person> Employees { get; set; }

        public Company(string name) {
            Name = name;
        }

        public void StartTheDay() {
            Employees = new List<Person>
                {
                    new Person {Name = "Mireille", Type = PersonType.Secretary},
                    new Person {Name = "Lucy", Type = PersonType.Management},
                    new Person {Name = "John", Type = PersonType.Management},
                    new Person {Name = "Richard", Type = PersonType.Management},
                    new Person {Name = "Stephen", Type = PersonType.IT},
                    new Person {Name = "Gerald", Type = PersonType.IT},
                    new Person {Name = "Marc", Type = PersonType.IT}
                };
        }

        public void LookFor(string target) {
            var type = (PersonType) Enum.Parse(typeof(PersonType), target);

            foreach (var person in Employees.Where(x => x.Type == type)) {
                LookForPeople += person.AttemptToTalk;
            }

            EventHandler<LookForEventArgs> handler = LookForPeople;

            if (handler != null) {
                handler(this, new LookForEventArgs { LookingFor = target });
            }
        }
    }
}