using NoName.Models.Domain;
using System.Collections.Generic;

namespace NoName.Models.Data.Repositories.Abstract {
    public interface IShowRepository {
        Show GetShowByID(int id);

        Show GetShowByTitle(string title);

        Episode GetEpisodeByID(int id);

        ICollection<Show> GetShows();

        void InsertShow(Show show);

        void InsertEpisode(Episode episode);
    }
}