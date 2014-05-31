namespace NoName.Models.Domain {
    public enum FAQCategory {
        General,
        Shows,
        Account
    }

    public class FAQ {
        public int ID { get; set; }

        public string Category { get; set; }

        public string Question { get; set; }

        public string Answer { get; set; }
    }
}