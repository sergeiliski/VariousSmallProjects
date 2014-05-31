using Android.App;
using Android.Content;
using Android.OS;
using Android.Widget;

namespace MultiScreen {
    [Activity(Label = "MultiScreen", MainLauncher = true, Icon = "@drawable/icon")]
    public class Main : Activity {
        protected override void OnCreate(Bundle bundle) {
            base.OnCreate(bundle);
            SetContentView(Resource.Layout.Main);

            var button = FindViewById<Button>(Resource.Id.ShowSecond);
            button.Click += (sender, e) => {
                var second = new Intent(this, typeof(Secondary));
                second.PutExtra("FirstData", "Data from Main activity");
                StartActivity(second);
            };

            var label = FindViewById<TextView>(Resource.Id.Main);
            label.Text = Intent.GetStringExtra("SecondData") ?? "No data available";
        }
    }
}