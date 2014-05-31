namespace NoName.Models.Domain {
    public class ShowScore {
        public int UserID { get; set; }

        public int ShowID { get; set; }

        public int Score { get; set; }

        public virtual User User { get; set; }

        public virtual Show Show { get; set; }
    }
}