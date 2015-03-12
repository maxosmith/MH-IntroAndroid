    // 
    // ScavengerItem
    //
    // Container class for information about a scavenger hunt item.
    // 
    private class ScavengerItem {
        private String name;
        private Bitmap icon;

        public ScavengerItem(String n){
            name = n;
            icon = null;
        }

        public ScavengerItem(String n, Bitmap b){
            name = n;
            icon = b;
        }

        public void setIcon(Bitmap b){
            icon = b; 
        }

        public Bitmap getIcon(){
            return icon;
        }

        public String getName(){
            return name;
        }
    } // ScavengerItem

    //
    // MyArrayAdapter
    //
    // Custom adapter to populate listview rows with ScavengerItems.
    //
    private class MyArrayAdapter extends ArrayAdapter<ScavengerItem>{
        private Context context;
        private ArrayList<ScavengerItem> values;

        public MyArrayAdapter(Context c, ArrayList<ScavengerItem> v){
            super(c, R.layout.row_item, v);
            context = c;
            values = v;
        }

        public View getView(int pos, View convertView, ViewGroup parent){
            // System service that handles creating UI elements
            LayoutInflater inflater =
                    (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            // Create the specific row's view
            View row = inflater.inflate(R.layout.row_item, parent, false);

            // Initialize UI for row
            TextView name = (TextView) row.findViewById(R.id.nameText);
            ImageView pict = (ImageView) row.findViewById(R.id.pictView);

            // Assign UI data
            name.setText(values.get(pos).getName());

            if (values.get(pos).getIcon() != null){
                pict.setImageBitmap(values.get(pos).getIcon());
            }

            return row;
        }
    } // MyArrayAdapter














    // Return handler
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_PICTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            items.get(cameraInsertPos).setIcon(imageBitmap);
            adapter.notifyDataSetChanged();
        }
    }