namespace NoName.Models.Data.Repositories.Abstract {
    public interface IAdministrator {
        void Crawl(int showID);

        void PopulateDatabase();

        void UpdateDatabase();
    }
}