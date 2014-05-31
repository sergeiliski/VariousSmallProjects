namespace NoName.Models.ViewModels {
    public class ShowScoreViewModel {
        public int UserID { get; set; }

        public int ShowID { get; set; }

        public int Score { get; set; }

        public UserViewModel User { get; set; }

        public ShowViewModel Show { get; set; }
    }
}