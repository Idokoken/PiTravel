import {
    FETCH_DATA_FAILURE, FETCH_DATA_REQUEST, FETCH_DATA_SUCCESS, POST_DATA_FAILURE, POST_DATA_REQUEST,
    POST_DATA_SUCCESS
} from './action'


const Reducer = (state, action) => {
    const { type, payload } = action

    switch (type) {
        case FETCH_DATA_REQUEST:
            return { ...state, loading: true };
        case FETCH_DATA_SUCCESS:
            console.log('getting post', payload)
            return { ...state, loading: false, posts: payload, error: null };
        case FETCH_DATA_FAILURE:
            return { ...state, loading: false, error: payload };

        case POST_DATA_REQUEST:
            return { ...state, loading: true };
        case POST_DATA_SUCCESS:
            console.log('getting post', payload)
            return { ...state, loading: false, posts: [...state.posts, payload], error: null };
        case POST_DATA_FAILURE:
            return { ...state, loading: false, error: payload };
        default:
            throw new Error(`No such action ${type}`)
        // return state
    }
}

export default Reducer