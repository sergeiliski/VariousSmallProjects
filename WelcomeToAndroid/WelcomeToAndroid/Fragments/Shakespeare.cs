using Android.App;
using Android.Content;
using Android.OS;
using Android.Runtime;
using Android.Views;
using Android.Widget;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Fragments {
    public static class Shakespeare {
        public static IList<string> Titles {
            get {
                return new List<string>(new[] { "Title 1", "Title 2", "Title 3" });
            }
        }

        public static IList<string> Dialogue {
            get {
                return new List<string>(new[] { "Blabla 1", "Blabla 2", "Blabla 3" });
            }
        }
    }
}