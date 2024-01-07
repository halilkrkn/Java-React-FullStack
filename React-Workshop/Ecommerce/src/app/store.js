import { configureStore } from '@reduxjs/toolkit'
import cartReducer from '../store/reducers/cartReducer'
import rootReducer from '../store/rootReducer'

export default configureStore({
  reducer: {
    cartReducer: cartReducer,
  },
})