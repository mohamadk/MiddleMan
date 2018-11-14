# MiddleMan
##### A Better way to handle items in recyclerView.

How do I use MiddleMan?
-------------------

Middleman is a library for helping handling items in recyclerView adapters with better following SOLID rules.     
it support both simple list and paging list in recyclerView.      

### what is the problem?
in almost all of the android applications recyclerview is a mandatory part.     
and adapter is the key point of implementing a recyclerview.

this is the way most people handle recyclerViewAdapters:

    class SampleRecyclerView: RecyclerView.Adapter<RecyclerView.ViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
    
            return when (viewType) {
                ViewType1 -> {
                    createViewHolder1()
                }
                ViewType2 -> {
                    createViewHolder2()
                }
                else -> {
    
                }
            }
        }
    
        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            holder.bind(items)
        }
    
        class ViewHolder1(val itemView1: View) : RecyclerView.ViewHolder(itemView1) {
    
        }
    
        class ViewHolder2(val itemView1: View) : RecyclerView.ViewHolder(itemView1) {
    
        }
        
        ....
    }

so whats wrong with this implementation?      

1- you have to modify your adapter every time you add a new item to your recyclerview.    
2- you have to create a different adapter for each page of your app or after a while 
you find your self in a big mess.       
3- you cannot interact with your fragment or activity from your items directly.     
4- if after a while some one new came to the development team they have problem in 
   finding items in each page of the application.    

#### Solution
Using the middleman      

How to Use Middle man?

create instance of GeneralViewAdapter and set it to recyclerView 

     recyclerView.apply {

            adapter = GeneralViewAdapter(this@SampleListFragment)
            // or for support paging in your list
            adapter = GeneralPagingViewAdapter(this@SampleListFragment)
            
            layoutManager = LinearLayoutManager(activity)
        }

implement BaseModel in every item model.
implement defaultResLayout or defaultViewClass method.    
you can declare a reslayout or a class of your customView item.     

    @Parcelize
    class ItemModel(val id:String,val name:String):BaseModel{
        override fun defaultResLayout(position: Int): Int? {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    
        override fun defaultViewClass(position: Int): Class<*>? {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    
    }
    
create a customView for each item in your recycler view that 
implement Binder interface and if need to interact with 
activity or fragment implement corresponding interactor.     

    open class ItemView @JvmOverloads constructor(
        context: Context,
        attributes: AttributeSet? = null,
        defStyleAttributes: Int = 0
    ) : LinearLayoutCompat(context, attributes, defStyleAttributes)
        , Binder<ItemModel>
        , RequireInteractor<SomeIntractor> {
    
        private lateinit var someIntractor: SomeIntractor
    
        override fun setInteractor(intractor: SomeIntractor) {
            this.someIntractor = intractor
        }
    
        override fun bind(item: ItemModel?) {
            ....
        }
    }
 
 and that's it.
 
 1- you don't need to modify adapter every time you create a new Item in list.       
 2- you don't need to create a different adapter for different pages.     
 3- you can easily interact with your fragment and activity from your items.    
 4- and if new member came in your development team because every item is custom view they
 can easily find the items in big project with help of layout inspector in android studio.
    