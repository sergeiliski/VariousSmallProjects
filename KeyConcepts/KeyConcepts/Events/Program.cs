using System;

namespace Events {
    internal class Program {
        /// <summary>
        /// An example that uses events to notify listeners about a particular action.
        /// The user has to decide who he wants to speak to: The secretary, IT or management
        /// The chosen people will get a notification and may or may not show up (randomly)
        /// </summary>
        /// <param name="args"></param>
        private static void Main(string[] args) {
            new Program();
        }

        public Program() {
            var company = new Company("IT Enterprises");
            var nsa = new NSA();

            company.StartTheDay();
            company.LookForPeople += nsa.Surveil;

            Console.WriteLine("Good morning! Welcome to {0}.\nWould you like to speak to the Secretary, Management or IT?", company.Name);
            var talkto = Console.ReadLine();
            company.LookFor(talkto);

            Console.Read();
        }
    }
}