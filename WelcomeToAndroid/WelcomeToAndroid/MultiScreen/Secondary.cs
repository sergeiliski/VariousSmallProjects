using Android.App;
using Android.Content;
using Android.OS;
using Android.Widget;

namespace MultiScreen {
    [Activity(Label = "Secondary activity")]
    public class Secondary : Activity {
        protected override void OnCreate(Bundle bundle) {
            base.OnCreate(bundle);
            SetContentView(Resource.Layout.Secondary);

            var label = FindViewById<TextView>(Resource.Id.SecondaryLabel);
            label.Text = Intent.GetStringExtra("FirstData") ?? "Data not available";

            var button = FindViewById<Button>(Resource.Id.ShowMain);
            button.Click += (sender, e) => {
                var main = new Intent(this, typeof(Main));
                main.PutExtra("SecondData", "I come from second");
                StartActivity(main);
            };
        }
    }
}