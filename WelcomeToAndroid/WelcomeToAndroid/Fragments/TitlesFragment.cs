using Android.App;
using Android.Content;
using Android.OS;
using Android.Runtime;
using Android.Util;
using Android.Views;
using Android.Widget;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Fragments {
    public class TitlesFragment : ListFragment {
        private bool _isDualPane;
        private int _currentPlayId;
        public override void OnCreate(Bundle savedInstanceState) {
            base.OnCreate(savedInstanceState);

            // Create your fragment here
        }

        public override void OnActivityCreated(Bundle savedInstanceState) {
            base.OnActivityCreated(savedInstanceState);

            var adapter = new ArrayAdapter<String>(Activity, Android.Resource.Layout.SimpleListItemChecked,
                                                   Shakespeare.Titles);
            ListAdapter = adapter;

            if (savedInstanceState != null) {
                _currentPlayId = savedInstanceState.GetInt("current_play_id", 0);
            }

            var detailsFrame = Activity.FindViewById<View>(Resource.Id.details);
            _isDualPane = detailsFrame != null && detailsFrame.Visibility == ViewStates.Visible;

            if (_isDualPane) {
                ListView.ChoiceMode = ChoiceMode.Single;
                ShowDetails(_currentPlayId);
            }
        }

        public override void OnListItemClick(ListView l, View v, int position, long id) {
            ShowDetails(position);
        }

        private void ShowDetails(int playId) {
            _currentPlayId = playId;
            if (_isDualPane) {
                ListView.SetItemChecked(playId, true);

                var details = FragmentManager.FindFragmentById(Resource.Id.details) as DetailsFragment;

                if (details == null || details.ShownPlayId != playId) {
                    details = DetailsFragment.NewInstance(playId);

                    var ft = FragmentManager.BeginTransaction();
                    ft.Replace(Resource.Id.details, details);
                    ft.SetTransition(FragmentTransit.FragmentFade);
                    ft.Commit();
                }
            } else {
                var intent = new Intent();
                intent.SetClass(Activity, typeof(DetailsActivity));
                intent.PutExtra("current_play_id", playId);
                StartActivity(intent);
            }
        }
    }
}