using System;
using System.Threading;

namespace Events {
    public enum PersonType {
        Secretary,
        IT,
        Management
    }

    public class Person {
        private static readonly ThreadLocal<Random> Rand = new ThreadLocal<Random>(() => new Random());

        public string Name { get; set; }
        public PersonType Type { get; set; }

        public void AttemptToTalk(object sender, LookForEventArgs e) {
            var intermediate = Rand.Value.Next(100);
            var result = intermediate > 50
                ? "On my way! ~ " + Name
                : "Sorry, I can't make it! ~ " + Name;

            Console.WriteLine(result);
        }
    }
}